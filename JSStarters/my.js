var a=function(){
	var d=new Date;

//	var c=function(){
		var s=0;
 // comment no sense
		for(var n=0;n<100;n++)
// no sense comment		
	for(var i=0;i<10000;i++)
// no any sense in comment	
			s+=i;
//	}();

	println(new Date-d);
}();

var s=0;

var b=function(){
	var d=new Date;
	
	var s=0;
	// var c=function(){
		for(var n=0;n<100;n++)
			for(var i=0;i<10000;i++)
				s+=i;
	// }();

	println(new Date-d);
}();




