/*
 * Copyright 2016 Farbod Safaei
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.binaryheart.common.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AlphanumericComparatorTest {

    @Test
    public void compareTwoNonEqual() {
        String s1 = "e";
        String s2 = "è";
      
        AlphaNumericComparator comparator = new AlphaNumericComparator();
        Assert.assertNotEquals(0, comparator.compare(s1, s2));
    }
    
    @Test
    public void compareTwoEqual() {
        String s1 = "Example-01-String1";
        String s2 = "Example-01-String1";
      
        AlphaNumericComparator comparator = new AlphaNumericComparator();
        Assert.assertEquals(0, comparator.compare(s1, s2));
    }
    
    @Test
    public void compareOneNull() {
        String s1 = "Example-01-String1";
        String s2 = null;
      
        AlphaNumericComparator comparator = new AlphaNumericComparator();
        Assert.assertEquals(1, comparator.compare(s1, s2));
    }
    
    @Test
    public void collatorSort() {
        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add("e");
        list.add("f");
        list.add("ě");
        list.add("è");
        list.add("g");
        list.add("k");
        
        Collections.sort(list);
        String[] defaultSorted = list.toArray(new String[list.size()]);
        
        list.sort(new AlphaNumericComparator());
        String[] versionSorted = list.toArray(new String[list.size()]);
        
        /*
         * Sorted output using Collections.sort(): [b, e, f, g, k, è, ě]
         * 
         * Sorted output using AlphaNumericComparator: [b, e, è, ě, f, g, k]
         */
        Assert.assertNotEquals(Arrays.toString(defaultSorted), Arrays.toString(versionSorted));
        
    }

    @Test
    public void fileNameSort() {
        List<String> list = new ArrayList<String>();
        list.add("file-01.doc");
        list.add("file-03.doc");
        list.add("file-2.doc");
        
        Collections.sort(list);
        String[] defaultSorted = list.toArray(new String[list.size()]);
        
        list.sort(new AlphaNumericComparator());
        String[] versionSorted = list.toArray(new String[list.size()]);
        
        /*
         * Sorted output using Collections.sort(): [file-01.doc, file-03.doc, file-2.doc]
         * 
         * Sorted output using AlphaNumericComparator: [file-01.doc, file-2.doc, file-03.doc]
         */
        Assert.assertNotEquals(Arrays.toString(defaultSorted), Arrays.toString(versionSorted));
    }

}
