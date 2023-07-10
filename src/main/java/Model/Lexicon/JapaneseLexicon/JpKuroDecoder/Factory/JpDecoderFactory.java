/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Factory;

import Model.Lexicon.Decoder.KuruDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Factory.Imp.JpFileDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Factory.Imp.JpFolderDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Factory.Imp.JpTextDecoder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Type.JpDecoderType;

public class JpDecoderFactory {
	 private JpDecoderFactory(){}
	 public static KuruDecoder BuildDecoder(JpDecoderType type){
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
