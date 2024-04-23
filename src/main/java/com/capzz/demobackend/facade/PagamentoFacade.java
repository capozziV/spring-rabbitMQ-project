package com.capzz.demobackend.facade;

import com.capzz.demobackend.dto.PagamentoDTO;
import com.capzz.demobackend.producer.PagamentoRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {

    @Autowired private PagamentoRequestProducer producer;
    public String solicitarPagamento(PagamentoDTO request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar pagamento: " + e.getMessage();
        }
        return "Pagamento aguardando confirmação";
    }

    public void sucessoPagamento(String payload) {
        System.out.println("==== Resposta de sucesso ====\n" + payload);
    }

    public void erroPagamento(String payload) {
        System.err.println("==== Resposta de erro ====\n" + payload);
    }
}
