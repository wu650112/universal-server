package com.us.bizs;

import com.us.bizs.unit.UsMathUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Us的单元测试
 *
 * @author wufan
 * @date 2023/12/20
 */
public class UsJunitTestOne {

    @Test
    public void testSum() {
        Integer result = 3;
        assertEquals(result, UsMathUnit.usSum(1, 1));
    }
}
