# kuru_indexer
   A tool for creating frecuency list for the japanese language. 
   this tool utilizes the [KuroMoji](https://github.com/atilika/kuromoji) for the  Japanese morphological analysis.
   This is a basic tool. And mainly one I needed for my personal needs. So use it at your own risk.
```
### Screenshot
![](https://i.ibb.co/8b2th26/image.png)

### Requisites to run the app
- Java 11 JRE.  
- The .Jar already has all the dependencies. 

### Input Example
```text
    終電はもうないよこれからどうしようかなんて迷い込みたいな二人で
    終点なんてないの明日の事なんてほら今は考えないでよね
    いつもと同じペースで歩く街に二人の影映すならんで見た景色は
    ほらいつまでも変わらないままであの頃は子供だったねと割り切るには
    ....
```
### Output Example

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
 

 The text example taken for this one: <br>
 - Song Artist: Ayase  - 夜撫でるメノウ
 ## License
 
 [![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
 
 - **[MIT license](http://opensource.org/licenses/mit-license.php)**
 
 
 
 