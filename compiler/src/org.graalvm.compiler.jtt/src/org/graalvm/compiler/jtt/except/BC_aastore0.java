/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
/*
 */
package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_aastore0 extends JTTTest {

    static Object[] param = {new Object(), null, "h"};
    static Object[] arr = {null, null, null};
    static String[] arr2 = {null, null, null};

    public static int test(boolean a, int indx) {
        Object[] array = a ? arr : arr2;
        Object val;
        if (indx == -2) {
            array = null;
            val = null;
        } else {
            val = param[indx];
        }
        array[indx] = val;
        return indx;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", true, -2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", true, -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", true, 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", true, 1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", true, 2);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", true, 3);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", false, 0);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", false, 1);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", false, 2);
    }

    @Test
    public void run9() throws Throwable {
        runTest("test", false, 3);
    }

}