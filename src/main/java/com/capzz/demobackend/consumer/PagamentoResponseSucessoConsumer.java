package com.capzz.demobackend.consumer;

import com.capzz.demobackend.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseSucessoConsumer {

    @Autowired
    PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void recebeMensagem(@Payload Message message){

        System.out.println("[" + LocalDateTime.now() + "] Mensagem de sucesso recebida: " + message);
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.sucessoPagamento(payload);

    }
}
