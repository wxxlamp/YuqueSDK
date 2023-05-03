package cn.wxxlamp.yuque.sdk.api;

import cn.wxxlamp.yuque.sdk.model.DocAbilities;
import cn.wxxlamp.yuque.sdk.model.DocDetailSerializer;
import cn.wxxlamp.yuque.sdk.model.DocNode;
import cn.wxxlamp.yuque.sdk.model.DocNodeOpe;
import cn.wxxlamp.yuque.sdk.model.YuqueApiResponse;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author chenkai
 * @version 2023/4/9 21:42
 */
public interface YuqueHttpApi {

    /**
     * 查询文档内容
     * @param repoId 知识库ID
     * @param slug 文档slug
     * @return 文档内容
     */
    @GET("/api/v2/repos/{userId}/{repoId}/docs/{slug}")
    YuqueApiResponse<DocAbilities, DocDetailSerializer> queryDocDetail(@Path("repoId") String repoId, @Path("slug") String slug);

    @GET("/api/v2/repos/{userId}/{repoId}/docs")
    YuqueApiResponse<DocAbilities, List<DocDetailSerializer>> queryDocList(@Path("repoId") String repoId);

    /**
     * 创建文档
     * @param repoId 知识库ID
     * @param docDetail 文档详情
     * @return 文档内容
     */
    @POST("/api/v2/repos/{userId}/{repoId}/docs")
    YuqueApiResponse<Void, DocDetailSerializer> createDoc(@Path("repoId") String repoId, @Body DocDetailSerializer docDetail);

    /**
     * 更新文档
     * @param repoId
     * @param docId
     * @param docDetail
     * @return
     */
    @PUT("/api/v2/repos/{userId}/{repoId}/docs/{docId}")
    YuqueApiResponse<Void, DocDetailSerializer> updateDoc(@Path("repoId") String repoId, @Path("docId") String docId, @Body DocDetailSerializer docDetail);

    @DELETE("/api/v2/repos/{userId}/{repoId}/docs/{docId}")
    YuqueApiResponse<Void, DocDetailSerializer> deleteDoc(@Path("repoId") String repoId, @Path("docId") String docId);


    /**
     * 查询目录
     * @param repoId
     * @return
     */
    @GET("/api/v2/repos/{userId}/{repoId}/toc")
    YuqueApiResponse<Void, List<DocNode>> queryDocNode(@Path("repoId") String repoId);

    /**
     * 操作文档
     * @param repoId
     * @param docNodeOpe
     * @return
     */
    @PUT("/api/v2/repos/{userId}/{repoId}/toc")
    YuqueApiResponse<Void, List<DocNode>> opeDocNode(@Path("repoId") String repoId, @Body DocNodeOpe docNodeOpe);
}
