package Services;
import java.util.Objects;

import Adapters.TokenFrecuencyAdapter;
import dto.TokenFrecuencyResponse;
import java.util.*;

import Api.TextFrecuencier;
import Api.TextTokenizer;
import KuroMoji.IpadicFrecuencyToken;
import KuroMoji.IpadicToken;

public class TokenService {
	
	
	private TextFrecuencier<IpadicFrecuencyToken, IpadicToken> frecuencier;
	private TextTokenizer<IpadicToken> tokenizer; 
	
	public TokenService (TextFrecuencier<IpadicFrecuencyToken, IpadicToken> frecuencier, TextTokenizer<IpadicToken> tokenizer) {
		Objects.requireNonNull(frecuencier);
		Objects.requireNonNull(tokenizer);
		this.frecuencier = frecuencier;
		this.tokenizer = tokenizer;
	}
	
	public List<TokenFrecuencyResponse> get_unprocessed_frecuency_response(String input){
		var adapter = new TokenFrecuencyAdapter();
		return this.tokenizer.tokenize(input).parallelStream().map(adapter::fromIpadicToken).toList();
	}
	public List<TokenFrecuencyResponse> get_processed_frecuency_response(String textInput){
		TokenFrecuencyAdapter adapter = new TokenFrecuencyAdapter();
		return this.frecuencier.PerformFrecuency(this.tokenizer.tokenize(textInput)).parallelStream().map(adapter::fromIpadicFrecuencyToken).toList();
	}
}
