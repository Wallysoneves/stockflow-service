package br.com.stockflowservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StockFlowException extends RuntimeException {

    private HttpStatus status;
    private Object retorno;

    public StockFlowException (String mensagem) {
        super(mensagem);
    }

    public StockFlowException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.status = status;
    }

    public StockFlowException(String mensagem, Throwable causa,HttpStatus status) {
        super(mensagem, causa);
        this.status = status;
    }

    public StockFlowException(String mensagem, Throwable causa, Object retorno, HttpStatus status) {
        super(mensagem, causa);
        this.retorno = retorno;
        this.status = status;
    }

    public StockFlowException(String mensagem, Object retorno, HttpStatus status) {
        super(mensagem);
        this.retorno = retorno;
        this.status = status;
    }

}
