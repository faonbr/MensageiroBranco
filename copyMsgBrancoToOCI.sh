rm MensageiroBranco.zip
zip -r MensageiroBranco.zip MensageiroBranco/
scp -i msgbranco.ppk MensageiroBranco.zip opc@132.145.208.121:/home/opc
echo "MensageiroBranco copiado para a Frontend-Server."

