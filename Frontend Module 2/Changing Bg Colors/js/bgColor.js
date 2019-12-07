
var changeColor = ["#CD5C5C", "#bf00ff", "#1a0000", "#FFFF33, #ff1a1a", "#ff4000", "#FFFF00", "#0040ff",
    "#ff00ff", "#FFFF99", "##996666","#0080ff" , "#222f3e"];

var j = 0;
document.querySelector("button").addEventListener("click",
    function(){
        j = j < changeColor.length ? ++j : 0;
        document.querySelector("body").style.background = changeColor[j]
    })