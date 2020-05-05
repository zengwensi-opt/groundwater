package com.groundwater.support.modules.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Pagination<T> extends Page<T> {
    private static final long serialVersionUID = 5194933845448697148L;

    private T param ;

    public Pagination(long current, long size,T param) {
        super(current, size);
        this.param = param;
    }
}
