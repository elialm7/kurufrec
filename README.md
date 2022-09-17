# kuru_indexer
   This a small tool I made for creating a japanese frecuency list. <br>
   It is not a serious project. I made it for myself...
   
   it is a .cmd that launches a .jar executable. <br>
   The .jar reads a properties file where the location of the files are written. 
   
   ## .Properties Example
   
   ```properties
   fromJar=true
   folderloc=
   wfolder=false
   fileloc=..\\data_test\\Larch1.txt
   wfile=true
   out=..\\data_test\\test_results.txt
```

##Input Example

```text
    終電はもうないよこれからどうしようかなんて迷い込みたいな二人で
    終点なんてないの明日の事なんてほら今は考えないでよね
    いつもと同じペースで歩く街に二人の影映すならんで見た景色は
    ほらいつまでも変わらないままであの頃は子供だったねと割り切るには
    ....
```
## Output Example

 ```text
 the amount of words: 99
 Index,Word,Reading,Pronunciation,Type,Frecuency,Romaji
 1,ない,ナイ,ナイ,Adjective,2,10,nai
 2,言葉,コトバ,コトバ,Noun,0,6,kotoba
 3,君,キミ,キミ,Noun,0,5,kimi
 4,愛,アイ,アイ,Noun,0,4,ai
 5,毎日,マイニチ,マイニチ,Noun,0,4,mainichi
 6,これ,コレ,コレ,Noun,0,4,kore
 7,終わり,オワリ,オワリ,Verb,1,4,owari
 8,人,ニン,ニン,Noun,0,3,nin
 9,今,イマ,イマ,Noun,0,3,ima
 10,届け,トドケ,トドケ,Noun,0,3,todoke
 11,のせる,ノセル,ノセル,Verb,1,3,noseru
 12,思え,オモエ,オモエ,Verb,1,3,omoe
 13,しまう,シマウ,シマウ,Verb,1,3,shimau
 14,なる,ナル,ナル,Verb,1,3,naru
 15,元気,ゲンキ,ゲンキ,Noun,0,3,genki
 16,い,イ,イ,Verb,1,3,i
 17,終電,シュウデン,シューデン,Noun,0,2,shuuden
 18,もう,モウ,モー,Adverb,4,2,mou
 .....
 ```
 
 ## How to Use.
 
 Within the properties files you have some options. 
 
 - folder and file.
 
 
 ###Folder and File. 
 
 When *fromjar* is true, then the .jar looks for the file from the bin location.<br>
 That's why you must add ´..\\´ before the path. If the it is false, then you musy provide the full location from C...
 
 When *wfolder* is true, then *wfile* must be false, and viceversa. *wfolder*  indicates that it's going to read a folder where 
 a series of files are there. 
 
 
 ### Download
 In the release section there is a .rar file with the examples and the program. 
 The text example taken for this one: <br>
 - Song Artist: Ayase  - 夜撫でるメノウ
 ## License
 
 [![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
 
 - **[MIT license](http://opensource.org/licenses/mit-license.php)**
 
 
 
 