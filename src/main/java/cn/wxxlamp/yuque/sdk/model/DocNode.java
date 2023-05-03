package cn.wxxlamp.yuque.sdk.model;

import lombok.Data;
import lombok.Getter;

/**
 * 节点
 * @author chenkai
 * @version 2023/4/9 23:25
 */
@Data
@Getter
public class DocNode {

    private String type;

    private String title;

    private String uuid;

    private String prev_uuid;

    private String child_uuid;

    private String parent_uuid;

    private String doc_id;

    private String slug;
}
