package Adapters;

import KuroMoji.IpadicToken;
import dto.TokenFrecuencyResponse;
import KuroMoji.IpadicFrecuencyToken;

public class TokenFrecuencyAdapter {
	
	public TokenFrecuencyResponse fromIpadicToken(IpadicToken token) {
		return new TokenFrecuencyResponse(token.surface(), token.speechpart(), token.conjugationForm(), token.baseform(), 0);
	}
	
	public TokenFrecuencyResponse fromIpadicFrecuencyToken(IpadicFrecuencyToken tk) {
		return new TokenFrecuencyResponse(tk.token().surface(),
				tk.token().speechpart(),
				tk.token().conjugationForm(),
				tk.token().baseform(), tk.frecuency());
	}

}
