/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Builder;

import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Builder.Imp.JpFileDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Builder.Imp.JpFolderDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Builder.Imp.JpTextDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Type.JpDecoderType;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.KuroDecoder;

public class JpDecoderBuilder {
	 private JpDecoderBuilder(){}
	 public static KuroDecoder BuildDecoder(JpDecoderType type){
	 	 if(type.equals(JpDecoderType.TEXT_TYPE)){
	 	 	 return new JpTextDecoder();
		 }else if (type.equals(JpDecoderType.FOLDER_TYPE)){
	 	 	 return new JpFolderDecoder();
		 }else if(type.equals(JpDecoderType.FILE_TYPE)){
	 	 	 return new JpFileDecoder();
		 }
		 return null;
	 }
}
