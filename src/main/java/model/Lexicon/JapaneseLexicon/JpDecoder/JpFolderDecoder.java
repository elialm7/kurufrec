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

public class JpFolderDecoder extends KuroDecoder<File, List<JpWord>>{
	 private File[] files;
	 private String AllString = "";
	 private List<Token> tokens;

	 @Override
	 public void set(File Indata) {
	 	 List<File> files_list = MyFolder.getFilePathList(Indata).get();
	 	 files = new File[files_list.size()];
	 	 files_list.toArray(files);
	 	 AllString = MyFolder.getStringFromFiles(files);
	 	 tokens = getTokenized(AllString);
	 }

	 @Override
	 public List<JpWord> get() {
		  return JpWordBuilder.fromTokens(tokens);
	 }
}
