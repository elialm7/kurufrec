/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroDecoder;


import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import Model.Lexicon.Decoder.Decoder;

import java.util.List;

public abstract class KuroDecoder<I, O> implements Decoder<I, O> {
	  private Tokenizer tokenizer;
	  protected List<Token> getTokenized(String string){
	  	 String ult = string.replace("\n", "").replace(" ", "");
	  	 tokenizer = new Tokenizer();
	  	 return tokenizer.tokenize(ult);
	  }
}
