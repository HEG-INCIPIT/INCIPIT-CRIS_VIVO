/* $This file is distributed under the terms of the license in LICENSE$ */

package org.vivoweb.webapp.controller.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.cornell.mannlib.vitro.webapp.controller.VitroRequest;
import edu.cornell.mannlib.vitro.webapp.controller.freemarker.FreemarkerHttpServlet;
import edu.cornell.mannlib.vitro.webapp.controller.freemarker.responsevalues.ExceptionResponseValues;
import edu.cornell.mannlib.vitro.webapp.controller.freemarker.responsevalues.ResponseValues;
import edu.cornell.mannlib.vitro.webapp.controller.freemarker.responsevalues.TemplateResponseValues;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ARKController", urlPatterns = {"/ark"})
public class ARKController extends FreemarkerHttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(ARKController.class);
    private static final String TEMPLATE_DEFAULT = "ark.ftl";

    @Override
    protected ResponseValues processRequest(VitroRequest vreq) {
        try {
            String david = "David";
            Map<String, Object> body = new HashMap<String, Object>();
            body.put("name", david);

            return new TemplateResponseValues(TEMPLATE_DEFAULT, body);
        } catch (Throwable e) {
            log.error(e, e);
            return new ExceptionResponseValues(e);
        }
    }

    @Override
    protected String getTitle(String siteName, VitroRequest vreq) {
        return "Page for creating ARKs";
    }

}
