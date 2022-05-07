
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package core.model.JpWording;

import core.model.JpWording.tok.FrecuencyWordBase;

import java.util.Comparator;

public class DefaultFrecuencyComparator<T extends FrecuencyWordBase> implements Comparator<T> {
	 @Override
	 public int compare(T o1, T o2) {
	 	 if(o1.getFrecuency()>o2.getFrecuency()){
	 	 	 return -1;
		 }else if(o1.getFrecuency()< o2.getFrecuency()){
	 	 	 return 1;
		 }else{
	 	 	 return 0;
		 }
	 }
}