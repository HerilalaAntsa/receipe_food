var tab = document.getElementById('tables');
function carre(x){
  return x*x;
}
function puissance(x){
  return Math.pow(x,3);
}
function racinecarre(x){
  return Math.sqrt(x);
}
function supprimer(){
  tab.innerHTML = "";
}
function resultat() {
  var nb = document.getElementById('nombre').value;
  var func = document.getElementsByName('fonctions')[0].value;
  if (nb>=0) {
    var res = func+"("+nb+")";
    res = eval(res);
    var ligne = document.createElement("tr");
    var col1 = document.createElement("td");
    col1.appendChild(document.createTextNode(nb));
    ligne.appendChild(col1);
    var col2 = document.createElement("td");
    col2.appendChild(document.createTextNode(func));
    ligne.appendChild(col2);
    var col3 = document.createElement("td");
    col3.appendChild(document.createTextNode(res));
    ligne.appendChild(col3);
    var col4 = document.createElement("td");
    // col4.appendChild(document.createTextNode("parite"));
    ligne.appendChild(col4);
    var col5 = document.createElement("td");
    ligne.appendChild(col5);
    var btn = document.createElement("button");
    btn.appendChild(document.createTextNode("Parité"));
    btn.setAttribute("onclick","ajax("+nb+",this.parentNode)");
    col5.appendChild(btn);
    ligne.appendChild(col5);
    tab.appendChild(ligne);
  }
}
function changeCouleur(color) {
   tab.setAttribute("style","color:"+color);
  }

function ajax(nb,col) {
  var xhr=getXMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState == 4) {
      if(xhr.status == 200){
        // col.appendChild(document.createTextNode("wawawawa"));
        var tab = JSON.parse(xhr.responseText);
        col.previousSibling.innerHTML = tab[0].idCategorie;
        //console.log(xhr.responseText);
        // alert(col);
        // alert("Received : "  + xhr.responseText);
      }
      else{
        alert("Error code :  " + xhr.status);
      }
    }
    // else {
    //     alert("en cours : " + xhr.readyState);
    //   }
  };
  xhr.open("GET", "parite.php?nombre="+nb, true);
  xhr.send(null);
}

function getXMLHttpRequest() {
  if (window.XMLHttpRequest) return new XMLHttpRequest();
  if (window.ActiveXObject) {
    var names = [ "Msxml2.XMLHTTP.6.0", "Msxml2.XMLHTTP.3.0", "Msxml2.XMLHTTP", "Microsoft.XMLHTTP" ];
    for(var i in names) {
      try {
         return new ActiveXObject(names[i]);
       } catch(e) {}
     }
   }
   window.alert("Votre navigateur ne prend pas en charge l'objet XMLHTTPRequest.");
    return null;
  }
