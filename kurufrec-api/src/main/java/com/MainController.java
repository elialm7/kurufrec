package com;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import KuroMoji.IpadicFrecuencier;
import KuroMoji.IpadicTokenizer;
import KuroMoji.IpadicTokenizerConfig;
import Services.*;
import dto.TokenFrecuencyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {

	@GetMapping("/")
	public List<TokenFrecuencyResponse> index(){
		IpadicTokenizer tokenizer = new IpadicTokenizer(IpadicTokenizerConfig.Default());
		IpadicFrecuencier frecuencier = new IpadicFrecuencier();
		TokenService service = new TokenService(frecuencier, tokenizer);
		return service.get_processed_frecuency_response("金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol");
	}
	
}
