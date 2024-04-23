package com.capzz.demobackend.api;

import com.capzz.demobackend.dto.PagamentoDTO;
import com.capzz.demobackend.facade.PagamentoFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("pagamentos")
@RestController
public class PagamentoController {

    @Autowired PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar(@RequestBody PagamentoDTO request) {

        return pagamentoFacade.solicitarPagamento(request);

    }

}
