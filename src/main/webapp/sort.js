function sort_price()
{

 var table=$('#maintable');
 var tbody =$('#table1');


 tbody.find('tr').sort(function(a, b)
 {
  if($('#price_order').val()=='asc')
  {
   return $('td:eq(1)', a).text().localeCompare($('td:eq(1)', b).text(), undefined, {numeric: true});
  }
  else
  {
   return $('td:eq(1)', b).text().localeCompare($('td:eq(1)', a).text(), undefined, {numeric: true});
  }

 }).appendTo(tbody);

 var sort_order=$('#price_order').val();

 if(sort_order=="asc")
 {
  document.getElementById("price_order").value="desc";

 }
 if(sort_order=="desc")
 {
  document.getElementById("price_order").value="asc";
 }
}

function changeArrow() {
     var element = document.getElementById("prices");
       element.classList.add("js-arrow-up");
  }



