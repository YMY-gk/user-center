package com.user.common.tree;

import com.user.dto.resp.MenuTree;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Tree<T> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 父ID
     */
    private Long parentId;


    List<T> childs;
}
