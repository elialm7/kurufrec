/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package model.Lexicon.JapaneseLexicon.JpDecoder;

import com.atilika.kuromoji.ipadic.Token;
import model.Folder.MyFolder;
import model.Lexicon.JapaneseLexicon.JpWord.JpWord;
import model.Lexicon.JapaneseLexicon.JpWord.JpWordBuilder;

import java.io.File;
import java.util.List;

public class JpFileDecoder extends KuroDecoder<File, List<JpWord>> {

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
