<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/style.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<style>
body{
	background: black; 
	font-family: Book Antiqua, cursive, sans-serif; 
	color: white;
}
nav.nav-justified{
	background: black;
}
a.nav-link{
	color: white;
}
a.nav-item.nav-link.active{
	background: #696969;
}
a.nav-item.nav-link.not-active{
	background: black;
}
a.nav-item.nav-link.not-active:hover{
	animation: color_change 2s;
}
@keyframes color_change {
	from { background-color: black; }
	to { background-color: grey; }
}
div.page-pizzeria{
	border-bottom: 20px solid black;
}
div.card-body-homepage{
	border-bottom: 29px solid black;
}
p.card-text-homepage{
	margin:0px;
}
div.row-pizzeria{
	width: 100%; 
	margin: 0px;
}
div.col-pizzeria{
	padding: 10px;
}
p.footer-pizzeria{
	font-size: 12px;
}
.modal {
    display: block;
    position: fixed;
    z-index: 6; 
    padding-top: 20px; 
    left: 0;
    top: 0;
    width: 100%; 
    height: 100%; 
    overflow: scroll; 
    background-color: rgb(0,0,0);
    background-color: rgba(0,0,0,0.9); 
}
.close {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}
.close:hover,
.close:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}
.basket-table{
	background: #696969; 
	color: white; 
	width: 50%; 
	border-radius: 10px;
}
.basket-table-element {
	border: 0px;
}
td.td-pizzeria{
	border: 0px;
}
th.th-pizzeria{
	border: 0px;
}
.input-data{
	background: #696969; 
	color: white;
}
</style>
</head>
<body onload="orderConfirm('${requestScope['order-confirm']}')">

	<nav class="nav nav-pills nav-justified" >
	  <a id="a-homepage" class="nav-item nav-link active" onClick="navItemClick(this.id)">Strona główna</a>
	  <a id="a-pizzas" class="nav-item nav-link not-active" onClick="navItemClick(this.id)">Pizza</a>
	  <a id="a-pastas" class="nav-item nav-link not-active" onClick="navItemClick(this.id)">Makarony</a>
	  <a id="a-salads" class="nav-item nav-link not-active" onClick="navItemClick(this.id)">Sałatki</a>
	  <a id="a-drinks" class="nav-item nav-link not-active" onClick="navItemClick(this.id)">Napoje</a>
	  <a id="a-contact" class="nav-item nav-link not-active" onClick="navItemClick(this.id)">Kontakt</a>
 	  <a id="a-basket" class="nav-item nav-link not-active" onClick="navBasketClick()"><i class="glyphicon glyphicon-shopping-cart">Koszyk</i></a>	
	</nav>

	<div class="card">
	<hr style="margin:0px;" noshade>
	  <img id="top-image" class="card-img-top" src="resources/pictures/pizzeria.jpg" alt="Card image cap" style="height: 400px;">
	</div>
	
	<div id="homepage" class="card text-white bg-dark page-pizzeria" style="display: block;">	  
	  <div class="card-body card-body-homepage">
	  <h4 align="center">Zapraszamy !</h4>
	  	<hr>
	    <p class="card-text card-text-homepage" align="center">Dlaczego warto skosztować naszej pizzy? Powodów jest kilka. </p>
	    <p class="card-text card-text-homepage" align="center">Przede wszystkim jedyna i niepowtarzalna receptura ciasta, staranny dobór składników oraz ścisła kontrola jakości.</p>
	    <p class="card-text card-text-homepage" align="center">To pozwala nam cieszyć się dobrą opinią od ponad 8 lat.</p>
	    <p class="card-text card-text-homepage" align="center">ZAMÓW SWOJĄ PIZZĘ ONLINE LUB ODWIEDŹ NASZ LOKAL.</p>
	  </div>
	</div>
	
	<div id="pizzas" class="card text-white bg-dark page-pizzeria" style="display: none;">	
		<div class="row row-pizzeria">
		<c:forEach var="pizza" items="${listPizzaElement}">
 		 <div class="col-sm-3 col-pizzeria">
			<div class="card" >
			  <img class="card-img-top" src="${pizza.src}" alt="Card image cap">
			  <div class="card-body">
			    <h4 class="card-title">${pizza.name}</h4>
			    <p class="card-text" style="height: 75px;">${pizza.description}</p>
				  <div class="btn-group" role="group" align="center">
				    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				      Zamów
				    </button>
				    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				    	<c:forEach var="product" items="${pizza.listPizzaProduct}">
      						<button class="dropdown-item" value="${product.idPizzaProduct}-pizza" onclick="productToBasket(this)">${product.pizzaType.getName()}- ${product.price}0 zł</button>
      					</c:forEach>
				    </div>
				  </div>			    
			  </div>
			</div>
  		</div>
  	   </c:forEach>
	   </div>
	</div>

	<div id="pastas" class="card text-white bg-dark page-pizzeria" style="display: none;">
	  <div class="row row-pizzeria">
		<c:forEach var="pasta" items="${listOtherProduct}">
		<c:if test="${pasta.productType.getIdProductType() eq 1}">
 		 <div class="col-sm-3 col-pizzeria">
			<div class="card" >
			  <img class="card-img-top" src="${pasta.element.src}" alt="Card image cap">
			  <div class="card-body">
			    <h4 class="card-title">${pasta.element.name}</h4>
			    <p class="card-text" style="height: 75px;">${pasta.element.description}</p>
			    <p>${pasta.price}0 zł</p>
				  <div class="btn-group" role="group" align="center">
				    <button type="button" class="btn btn-secondary" value="${pasta.idOtherProduct}-pasta"  onclick="productToBasket(this)">Zamów</button>
				  </div>			    
			  </div>
			</div>
  		</div>
  	   </c:if>
  	   </c:forEach>
	   </div>
	</div>
	
	<div id="salads" class="card text-white bg-dark page-pizzeria" style="display: none;">
	  <div class="row row-pizzeria">
		<c:forEach var="salad" items="${listOtherProduct}">
		<c:if test="${salad.productType.getIdProductType() eq 2}">
 		 <div class="col-sm-3 col-pizzeria">
			<div class="card" >
			  <img class="card-img-top" src="${salad.element.src}" alt="Card image cap">
			  <div class="card-body">
			    <h4 class="card-title">${salad.element.name}</h4>
			    <p class="card-text" style="height: 75px;">${salad.element.description}</p>
			    <p>${salad.price}0 zł</p>
				  <div class="btn-group" role="group" align="center">
				    <button type="button" class="btn btn-secondary" value="${salad.idOtherProduct}-salad" onclick="productToBasket(this)">Zamów</button>
				  </div>			    
			  </div>
			</div>
  		</div>
  	   </c:if>
  	   </c:forEach>
	   </div>
	</div>
	
	<div id="drinks" class="card text-white bg-dark page-pizzeria" style="display: none;">
	  <div class="row row-pizzeria">
		<c:forEach var="drink" items="${listOtherProduct}">
		<c:if test="${drink.productType.getIdProductType() eq 3}">
 		 <div class="col-sm-3 col-pizzeria">
			<div class="card" >
			  <img class="card-img-top" src="${drink.element.src}" alt="Card image cap">
			  <div class="card-body">
			    <h4 class="card-title">${drink.element.name}</h4>
			    <p class="card-text" style="height: 30px;">${drink.element.description}</p>
			    <p>${drink.price}0 zł</p>
				  <div class="btn-group" role="group" align="center">
				    <button type="button" class="btn btn-secondary" value="${drink.idOtherProduct}-drink"  onclick="productToBasket(this)">Zamów</button>
				  </div>			    
			  </div>
			</div>
  		</div>
  	   </c:if>
  	   </c:forEach>
	   </div>
	</div>	
	
	<div id="contact" class="card text-white bg-dark page-pizzeria" style="display: none;">
	  <div class="card-body">  
	  <h4 align="center" >Nasz lokal: </h4>
	  <hr>
		<div align="center" class="card" style="width: 40rem; margin: auto";>
			  <iframe class="card-img-top" alt="Card image cap" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d4888.244654743134!2d21.022899954318902!3d52.222995317483296!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spl!2spl!4v1517930636366" width="400" height="300" frameborder="0" style="border:1px solid black;" allowfullscreen></iframe>
			  <div class="card-body">
			    <p class="card-text" align="center">Ul. Pepperoni 50</p>
			    <p class="card-text" align="center">03-982 Warszawa</p>
			    <p class="card-text" align="center">Tel. (22) 6x3-44-88</p>
			  </div>
		 </div>
	  </div>	
	</div>
	
	<div>
		<p align="center" class="footer-pizzeria">Z zastrzeżeniem możliwości skrócenia godzin otwarcia. Wszystkie prawa zastrzeżone.</p>
	</div>

	<div align="center" class="modal" id="modal" style="display: none;">
	  <span class="close" id="modal-close">&times;</span>
	  <div id="modal-basket">
		  <h3>Koszyk</h3>
		  <h6 id="h6-pizza" style="display: none;">Pizza:</h6>
		  <table class="table table-dark basket-table" id="pizza-basket-table" style="display: none;"><tbody></tbody></table>
		  <h6 id="h6-pasta" style="display: none;">Makarony:</h6>
		  <table class="table table-dark basket-table" id="pasta-basket-table" style="display: none;"><tbody></tbody></table>
		  <h6 id="h6-salad" style="display: none;">Sałatki:</h6>
		  <table class="table table-dark basket-table" id="salad-basket-table" style="display: none;"><tbody></tbody></table>
		  <h6 id="h6-drink" style="display: none;">Napoje:</h6>
		  <table class="table table-dark basket-table" id="drink-basket-table" style="display: none;"><tbody></tbody></table>
		  <hr style="margin:0px;" noshade>	
		  <div class="card-body" style="width: 50%;" >
			  <div id="alert-order" class="alert alert-danger" role="alert" style="padding: 10px;">
					<p id="alert-order-p1"></p>
					<p id="alert-order-p2"></p>
			  </div>
			  <button onclick="headingSearch(this.form)" id="to-form" type="button" class="btn btn-secondary btn-lg">Przejdź dalej</button>
		  </div>		  	  
	  </div>
	  <div id="modal-order" style="display: none;">
		  <div style="width: 3%;">
		  	 <a class="btn btn-outline-secondary" id="to-basket"><i class="glyphicon glyphicon-menu-left" style="margin-top: 3px;"></i></a>	
		  </div>
	  	  <h3 style="margin-top: 10px;">Dane kontaktowe</h3>
			<form  method="post" action="ServletOrder" id="servlet-order">
			  <div style="width: 50%;">
			  <div class="form-row" >
			    <div class="form-group col-md-6">
			      <label for="inputEmail4">Imię<span style="color: red;">*</span></label>
			      <input type="text" class="form-control input-data" maxlength="50" name="firstname" id="firstname" onblur="checkData(this)" placeholder="Imię">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputPassword4">Nazwisko<span style="color: red;">*</span></label>
			      <input type="text" class="form-control input-data" maxlength="50" name="lastname" id="lastname" onblur="checkData(this)" placeholder="Nazwisko">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputEmail4">E-mail<span style="color: red;">*</span></label>
			      <input type="email" class="form-control input-data" maxlength="50" name="email" id="email" placeholder="E-mail" onblur="checkData(this)">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputPassword4">Numer telefonu<span style="color: red;">*</span></label>
			      <input type="tel" class="form-control input-data" maxlength="9"  name="phone" id="phone" placeholder="Numer telefonu" onblur="checkData(this)">
			    </div>
			  </div>			  
			  <div class="form-group">
			    <label for="inputAddress">Ulica<span style="color: red;">*</span></label>
			    <input type="text" class="form-control input-data" maxlength="50" name="street" id="street" onblur="checkData(this)" placeholder="Ulica">
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="inputZip">Nr domu<span style="color: red;">*</span></label>
			      <input type="text" class="form-control input-data" maxlength="5" name="house-numer" onblur="checkData(this)" id="house-numer" >
			    </div>			    
			    <div class="form-group col-md-2">
			      <label for="inputZip">Nr mieszkania</label>
			      <input type="text" class="form-control input-data" maxlength="5" name="apartment-numer" onblur="checkData(this)" id="apartment-numer">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="inputZip" >Kod pocztowy<span style="color: red;">*</span></label>
			      <input type="text" class="form-control input-data" maxlength="6" name="zip-code" onblur="checkData(this)" id="zip-code" placeholder="xx-xxx">
			    </div>			  
			    <div class="form-group col-md-6">
			      <label for="inputCity">Miasto<span style="color: red;">*</span></label>
			      <input type="text" class="form-control input-data" maxlength="50" name="city" id="city" onblur="checkData(this)" placeholder="Miasto">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Komentarz</label>
			    <textarea class="form-control input-data" maxlength="1000" name="comment" id="comment" rows="3"></textarea>
			  </div>			  
			  <div class="form-group">
			    <div class="form-check">
			      <label class="form-check-label">
			        <input class="form-check-input" type="checkbox" name="newsletter" id="newsletter" value="true" > Chcę otrzymywać newsletter!
			      </label>
			    </div>
			  </div>
			  </div>
			  <hr style="margin:0px;" noshade>
			  <div style="padding: 10px;">			  
				  <button id="to-order" type="button" onclick="toPost()" class="btn btn-secondary btn-lg">Zamawiam</button>
			  </div>
			</form>
	  </div>
	</div>
<input type="hidden">
	
<script>


var order= {
	    product: [] 
};
function navItemClick(id){
	$(".nav-item.nav-link.active").attr("class", "nav-item nav-link not-active");  	
	$('#'+id).attr("class", "nav-item nav-link active");  	

	switch (id) {
    case "a-homepage":	
    	$("#top-image").attr("src", "resources/pictures/pizzeria.jpg");
    	setDisplayDiv('homepage');
        break;
    case "a-pizzas":
    	$("#top-image").attr("src", "resources/pictures/background/pizza.jpg");
    	setDisplayDiv('pizzas');
        break;
    case "a-pastas":
    	$("#top-image").attr("src", "resources/pictures/background/makarony.jpg");
    	setDisplayDiv('pastas');
        break;
    case "a-salads":
    	$("#top-image").attr("src", "resources/pictures/background/salatki.jpg");
    	setDisplayDiv('salads');
        break;
    case "a-drinks":
    	$("#top-image").attr("src", "resources/pictures/background/napoje.jpg");
    	setDisplayDiv('drinks');
        break;
    case "a-contact":
    	$("#top-image").attr("src", "resources/pictures/background/kontakt.jpg");
    	setDisplayDiv('contact');
        break;    
	}    	
}
$(document).ready(function(){
    $(".dropdown-item").click(function(){
    	$('#page-background').attr("value", "pizzas");
    });
    $("#to-form").click(function(){
    	$("#modal-basket").hide();
    	$("#modal-order").show();
    });
    $("#to-basket").click(function(){
    	$("#modal-basket").show();
    	$("#modal-order").hide();
    });
    $("#modal-close").click(function(){
    	$("#modal").hide();
    });
});
function setDisplayDiv(element){
	var idDiv= ['homepage', 'pizzas', 'pastas', 'salads', 'drinks', 'contact'];
	
	for(var i=0; i<idDiv.length; i++){
		if(element!=idDiv[i])		
			$("#"+idDiv[i]).hide();
		else{
			$("#"+idDiv[i]).show();
		}
	}
}
function navBasketClick(){
	$("#modal").show();
	$("#modal-basket").show();
	$("#modal-order").hide();
	alertOrder();
}
function alertOrder(){
	var length=order.product.length;
	if(length==0){
		$("#alert-order").attr('class', 'alert alert-dark');
		$("#alert-order-p1").html('Na chwile obecną Twój koszyk jest pusty.');
		$("#alert-order-p2").hide();
		$("#to-form").hide();
	}
	else{
		var price=0;
		for(var i=0; i<length; i++){
			price+=new Number(order.product[i].price * order.product[i].quanity);	
		}
		price=parseFloat(price).toFixed(2);
		if(price<30){
			var rest=30-price;
			rest=parseFloat(rest).toFixed(2);
			$("#alert-order").attr('class', 'alert alert-danger');
			$("#alert-order-p1").html('Razem: '+price+' zł');
			$("#alert-order-p2").show();
			$("#alert-order-p2").html('Wartość zamówienia musi przekraczać 30 zł (brakuje: '+rest+' zł)');
			$("#to-form").hide();
		}
		else{
			$("#alert-order").attr('class', 'alert alert-success');
			$("#alert-order-p1").html('Razem: '+price+' zł');
			$("#alert-order-p2").show();
			$("#alert-order-p2").html('Wartość twojego zamówienia umożliwia Ci dokonania zakupu.');
			$("#to-form").show();
		}	
	}
}
function productToBasket(element){
	var param = element.value.split("-");
	var idProduct=param[0];
	
	if(param[1]=='pizza'){
		<c:forEach var="pizza" items="${listPizzaElement}">
			<c:forEach var="product" items="${pizza.listPizzaProduct}">
			var idPizzaProduct=${product.idPizzaProduct};	
				if(idPizzaProduct==idProduct){	
					productToBasketElements('${product.idPizzaProduct}', '${pizza.name}'+'- '+'${product.pizzaType.getName()}', '${product.price}', 'pizza');				
				}
			</c:forEach>
		</c:forEach>
	}
	else{
		switch(param[1]){
	    case 'pasta':
			<c:forEach var="pasta" items="${listOtherProduct}">
			var idProductType=${pasta.productType.getIdProductType()};
				if(idProductType==1){			
					var idPastaProduct=${pasta.idOtherProduct};
		    		if(idPastaProduct==idProduct){
		    			productToBasketElements('${pasta.idOtherProduct}', '${pasta.element.name}', '${pasta.price}', 'pasta');
		    		}
				}
	  		</c:forEach>
	        break;
	    case 'salad':
			<c:forEach var="salad" items="${listOtherProduct}">
			var idProductType=${salad.productType.getIdProductType()};
				if(idProductType==2){
				var idSaladProduct=${salad.idOtherProduct};
		    		if(idSaladProduct==idProduct){
		    			productToBasketElements('${salad.idOtherProduct}', '${salad.element.name}', '${salad.price}', 'salad');
		    		}
				}
	  		</c:forEach>
	        break;
	    case 'drink':
			<c:forEach var="drink" items="${listOtherProduct}">
			var idProductType=${drink.productType.getIdProductType()};
				if(idProductType==3){
				var idDrinkProduct=${drink.idOtherProduct};
		    		if(idDrinkProduct==idProduct){
		    			productToBasketElements('${drink.idOtherProduct}', '${drink.element.name}', '${drink.price}', 'drink');
		    		}
				}
	  		</c:forEach>
	        break;
		}
	}

}
function productToBasketElements(id, name, price, type){
	var count=0;
	for(var i=0; i<order.product.length; i++){
		if(order.product[i].id==id){
			count++;
		}
	}
	if(count==0){		    
		$("#modal").show();
		var title= convertTitle(name);
		$("#"+type+"-basket-table").append("<tr id=\"tr-"+type+"-"+id+"\"><td style=\"border: 0px; width: 50%;\">"+title+"</td><td style=\"border: 0px; width: 20%\"><input style=\"background: #696969; color: white;\" class=\"form-control\" type=\"number\" name=\"quantity\" min=\"1\" max=\"20\" onblur=\"checkQuanity(this)\" value=\"1\" id=\"input-"+type+"-"+id+"\" onClick=\"changeQuantity(this)\"></td><td id=\"price-"+type+"-"+id+"\" style=\"border: 0px; width: 20%\">"+parseFloat(price).toFixed(2)+" zł</td><td style=\"border: 0px; width: 10%\"><button type=\"button\" class=\"btn btn-secondary\" id=\"delete-"+type+"-"+id+"\" onClick=\"deleteProduct(this)\"><i class=\"glyphicon glyphicon-trash\"></i></button></td></tr></tr>");
		$("#h6-"+type).show();
		$("#"+type+"-basket-table").show();
		order.product.push({id: id, type: type, price: price, quanity: 1});
    	alertOrder();
	}
	else{
		alert("Wybrany produkt już został umieszczony w koszyku.")
	}
}
function convertTitle(title){
	var lower=title.substring(1).toLowerCase();
	var upper=title.substring(0, 1);
	var newTitle=upper+lower;
	return newTitle;
}
function checkQuanity(element){
	var value= new Number(element.value);
	
	if(value>20){
		$('#'+element.id).val(20);
	}
	else if(value<=0){
		$('#'+element.id).val(1);
	}
}
function changeQuantity(element){
	var idElement=element.id;
	var quanity= new Number(element.value);
	var elements= idElement.split('-');
	
	var price=0;
	for(var i=0; i<order.product.length; i++){
		if(order.product[i].id==elements[2]){
			price=new Number(order.product[i].price);
			order.product[i].price=price;
			order.product[i].quanity=quanity;
		}
	}
	var newPrice=price*quanity;
	
	var elementPrice= idElement.replace('input', 'price');
	$( "#"+elementPrice).html(parseFloat(newPrice).toFixed(2)+' zł');
	alertOrder();
}
function deleteProduct(element){
	var idElement=element.id;
	idElement= idElement.replace('delete', 'tr');
	var elements= idElement.split('-');
	$( "#"+idElement).remove();
	
	var i=0;
	
	for(var j=0; j<order.product.length; j++){
		if(order.product[j].type==elements[1]){	
		i++;
			if(order.product[j].id==elements[2]){
				if((order.product.length-1)==j){
					order.product.pop(); 
				}
				else{
					var a= order.product.length-(j+1);
					var orderSave= {
						    product: [] 
					};
					for(var k=0; k<a; k++){
						var prod= order.product.pop();
						orderSave.product.push({id: prod.id, type: prod.type, price: prod.price, quanity: prod.quanity});
					}
					order.product.pop();
					for(var k=0; k<a; k++){
						order.product.push({id: orderSave.product[k].id, type: orderSave.product[k].type, price: orderSave.product[k].price, quanity: orderSave.product[k].quanity});
					}
				}
			}
		}
	}
	navBasketClick();
	if(i==1){
		switch(elements[1]){
	    case 'pizza':
	    	$("#h6-pizza").hide();
	    	$("#pizza-basket-table").hide();
	        break;
	    case 'pasta':
	    	$("#h6-pasta").hide();
	    	$("#pasta-basket-table").hide();
	        break;
	    case 'salad':
	    	$("#h6-salad").hide();
	    	$("#salad-basket-table").hide();
	        break;
	    case 'drink':
	    	$("#h6-drink").hide();
	    	$("#drink-basket-table").hide();
	        break;
		}
	}
}
function checkData(element){
	var id=element.id;
	switch(id){
	case 'firstname':
		setBorderInput('^.{2,}$', 'firstname');
		break;
	case 'lastname':
		setBorderInput('^.{2,}$', 'lastname');
		break;
	case 'email':
		setBorderInput('^[0-9a-zA-Z_.-]+@[0-9a-zA-Z.-]+\.[a-zA-Z]{2,3}$', 'email');
		break;
	case 'phone':
		setBorderInput('^\\d{9}$', 'phone');		
		break;	
	case 'street':
		setBorderInput('^.{2,}$', 'street');
		break;	
	case 'house-numer':
		setBorderInput('^.{1,}$', 'house-numer');
		break;	
	case 'zip-code':
		setBorderInput('^\\d{2}-\\d{3}$', 'zip-code');
		break;	
	case 'city':
		setBorderInput('^.{2,}$', 'city');
		break;	
	}
}
function setBorderInput(reg, idInput){
	var text= $("#"+idInput).val();
	var reg= new RegExp(reg);
	
	if(reg.test(text)){
		$('#'+idInput).css("border-color", "#ccc");
		return 0;
	}
	else{
		$('#'+idInput).css("border-color", "red");	
		return 1;
	}
}
function toPost(){
	var count=checkDataFinally();
	if(count==0){
		for(var i=0; i<order.product.length; i++){
			$('#servlet-order').append('<input type="hidden" name="'+(i+1)+'-id" value="'+order.product[i].id+'">');
			$('#servlet-order').append('<input type="hidden" name="'+(i+1)+'-type" value="'+order.product[i].type+'">');
			$('#servlet-order').append('<input type="hidden" name="'+(i+1)+'-price" value="'+order.product[i].price+'">');
			$('#servlet-order').append('<input type="hidden" name="'+(i+1)+'-quanity" value="'+order.product[i].quanity+'">');
		}
		$('#servlet-order').submit();
	}
}
function checkDataFinally(){
	var count=0;
	count+=setBorderInput('^.{2,}$', 'firstname');
	count+=setBorderInput('^.{2,}$', 'lastname');
	count+=setBorderInput('^[0-9a-zA-Z_.-]+@[0-9a-zA-Z.-]+\.[a-zA-Z]{2,3}$', 'email');
	count+=setBorderInput('^\\d{9}$', 'phone');		
	count+=setBorderInput('^.{2,}$', 'street');
	count+=setBorderInput('^.{1,}$', 'house-numer');
	count+=setBorderInput('^\\d{2}-\\d{3}$', 'zip-code');
	count+=setBorderInput('^.{2,}$', 'city');
	return count;
}
function orderConfirm(element){
	if(element=='order-confirm'){
		alert("Na twój adres e-mail zostało wysłane potwierdzenie zamówienia. Dziękujemy!");
	}
}
</script>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
</body>
</html>