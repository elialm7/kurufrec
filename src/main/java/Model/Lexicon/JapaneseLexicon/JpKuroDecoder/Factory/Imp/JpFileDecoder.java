/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Factory.Imp;

import Model.Folder.MyFolder;
import Model.Lexicon.Decoder.KuruDecoder;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWord;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWordBuilder;
import com.atilika.kuromoji.ipadic.Token;

import java.io.File;
import java.util.List;

public class JpFileDecoder extends KuruDecoder<File, List<JpWord>> {

	 List<Token> tokens;
	 @Override
	 public void set(File Indata) {
		  tokens = getTokenized(MyFolder.getStringFromFile(Indata));
	 }

	 @Override
	 public List<JpWord> get() {
		  return JpWordBuilder.fromTokens(tokens);
	 }
}
