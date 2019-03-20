package rtl.tot.corp.sche.invm.cmd.stockcmd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters.CreateStockCommandImpl;
import rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters.DecoratorCreateStockCommandBus;
import rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters.DecoratorUpdateStockCommandBus;
import rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters.UpdateStockCommandImpl;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.http.rest.constants.RestConstants;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.http.rest.domain.APIResponse;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.http.rest.domain.Stock;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.http.rest.domain.StockUpdate;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.EventProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/")
@Api(value = "ORION", description = "ORION Stock API")
@Slf4j
@EnableSwagger2
public class StockController {

	@Autowired
	private EventProperties eventProperties;
	
	@Autowired
	private HttpServletRequest context;

	@Autowired
	DecoratorCreateStockCommandBus cmdBus;

	@Autowired
	DecoratorUpdateStockCommandBus cmdBusUpdate;

	@RequestMapping(path = "/sche/invm/v1.0/stock", method = POST)
	@ApiOperation(value = "Create Stock", response = APIResponse.class)
	public ResponseEntity<APIResponse> createStock(@RequestBody Stock request) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
	
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		// E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Create Stock request.", request.toString());
		try {

			CreateStockCommandImpl cmd = new CreateStockCommandImpl(request);

			if (cmdBus.execute(cmd))
				log.info("Stock Created successful ", request.getSku());
			else{
				log.info("Stock not Created ", request.getSku());
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Stock not Created"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Stock Created Exception ", request.getSku());
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Stock Created"), HttpStatus.OK);
	}

	
	@RequestMapping(path = "/sche/invm/v1.0/stock", method = PUT)
	@ApiOperation(value = "Update Stock", response = APIResponse.class)
	public ResponseEntity<APIResponse> updateStock(@RequestBody StockUpdate request) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
	
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		// E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Update Stock request.", request.toString());
		try {

			UpdateStockCommandImpl cmd = new UpdateStockCommandImpl(request);

			if (cmdBusUpdate.execute(cmd))
				log.info("Stock Updated successful ", request.getSku());
			else{
				log.info("Stock not Updated ", request.getSku());
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Stock not Updated"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Stock Updated Exception ", request.getSku());
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Stock Updated"), HttpStatus.OK);
	}
	
	/**
	 * API success response
	 *
	 * @return
	 */

	private APIResponse buildSuccessRes(String msg) {
		APIResponse res = new APIResponse();
		res.setCode(RestConstants.SUCCESS_CODE);
		res.setType(RestConstants.SUCCESS_RESPONSE);
		res.setMessage(msg);
		return res;
	}

	/**
	 * API Error response
	 *
	 * @return
	 */
	private APIResponse buildErrorRes(String error) {
		APIResponse res = new APIResponse();
		res.setCode(RestConstants.ERROR_CODE);
		res.setType(RestConstants.SYSTEM_ERROR);
		res.setMessage(error);
		return res;
	}

}