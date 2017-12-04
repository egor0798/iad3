

//перерисуй канвас, он какой-то поехавший


window.onload= function() {
    var canvas = document.getElementById("myCanvas");
    var context = canvas.getContext("2d");
    context.beginPath();
    context.moveTo(0,250);
    context.lineTo(500,250);
    context.moveTo(250,0);
    context.lineTo(250,500);
    context.stroke();

    context.fillStyle="#0000FF";
    context.fillRect(50,250,250,450);

    context.beginPath();
    context.moveTo(450,250);
    context.lineTo(250,450);
    context.lineTo(250,250);
    context.lineTo(450,250);
    context.fillStyle="#0000FF";
    context.fill();
    context.stroke();

    var radius = 100;
    var start = Math.PI;
    var end = 1.5* Math.PI;
    context.beginPath();
    context.arc(250,250,radius,start,end,false);
    context.moveTo(250,150);
    context.lineTo(250,250);
    context.lineTo(150,250);
    context.fillStyle="#0000FF";
    context.fill();
    context.stroke();
}