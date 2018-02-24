# HadoopJavaExample


Exemplo simples de uso do hadoop em uma aplicação de MapReduce

OBS: para este exemplo, é necessario ja possuir o ambiente hadoop previamente configurado.

- Neste exemplo usamos um arquivo armazenado no HDFS (tweets.txt), efetuamos a execução do hadoop usando o aplicação jar gerada atraves do fonte deste repositorio, e por último, enviamos a resultado novamente ao HDFS com o resumo dos dados.

Passos para executar:

<b>1- envio da base ao HDFS:</b>

$ hadoop fs -mkdir bases/
$ hadoop fs -put tweets.txt bases/
$ hadoop fs -ls bases/

ele deve mostrar isso:
-rw-r--r-- 1 hadoopuser supergroup ... bases/tweets.txt

<b>2- execução da aplicação</b>  

$ hadoop jar $HOME/ContaHashtags.jar bases/ saida/

OBS: dependendo da forma que distribuiu seu jar, deve ser mencionado o mainclass, se executar o code deste repositorio com maven nao precisa se preocupar ;)


<b>3- Verifique a saida:</b>
$ hadoop fs -ls saida

Found 2 itens
-rw-r--r--   1 hdpuser ... /saida/_SUCCESS
drwxr-xr-x   - hdpuser ... /saida/_logs
-rw-r--r--   1 hdpuser ... /saida/part-r-00000

caso queira ver o arquivo de saida:
$ hadoop fs -cat saida/part-r-00000