package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoDBBO;
import br.com.webmonitor.entity.MonitoramentoDB;
import br.com.webmonitor.repository.MonitoramentoDBRepository;
import br.com.webmonitor.service.Generic.GenericService;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentodb")
public class MonitoramentoDBService extends MonitoramentoGenericService<MonitoramentoDB, MonitoramentoDBBO, MonitoramentoDBRepository> {

}