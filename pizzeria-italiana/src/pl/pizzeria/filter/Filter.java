package pl.pizzeria.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import pl.pizzeria.model.PizzaElement;
import pl.pizzeria.model.OtherProduct;
import pl.pizzeria.service.OtherProductService;
import pl.pizzeria.service.PizzaProductService;


@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

    public Filter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	HttpServletRequest req=(HttpServletRequest)request;
    	
    	if(req.getSession().getAttribute("listPizzaElement")==null && req.getSession().getAttribute("listOtherProduct")==null){
    		List<PizzaElement> listPizzaElement= PizzaProductService.getAllPizzaElement();
    		List<OtherProduct> listOtherProduct= OtherProductService.getAllOtherElement();
    		
    		req.getSession().setAttribute("listPizzaElement", listPizzaElement);
    		req.getSession().setAttribute("listOtherProduct", listOtherProduct);
    		for (OtherProduct otherProduct : listOtherProduct) {
    			otherProduct.getElement().getName();
    			otherProduct.getElement().getIdElement();
			}
    		for (PizzaElement otherProduct : listPizzaElement) {
				otherProduct.getIdElement();
				otherProduct.getName();
			}
    	}
    	
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
