function compile() {
    var html = document.getElementById("html");
    var code = document.getElementById("code").contentWindow.document;
  
    document.body.onclick = function() {
      code.open();
      code.writeln(
         html.value
      );
      code.close();
    };
  }
  
  compile();