package br.com.webmonitor.service;

import br.com.webmonitor.business.ServidorConfigBO;
import br.com.webmonitor.entity.ServidorConfig;
import br.com.webmonitor.repository.ServidorConfigRepository;
import br.com.webmonitor.service.Generic.GenericService;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor/{idServidor}/servidorconfiguracoes")
public class ServidorConfigServer extends InformacoesGenericService<ServidorConfig, ServidorConfigBO, ServidorConfigRepository> {

}