/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.Decoder;

public interface Decoder<I, O> {
	 void set(I Indata);
	 O get();
}
