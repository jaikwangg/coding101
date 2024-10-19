from socket import * # include Python's Library
 
serverName = 'hostname'
serverPort = 12000

clientSocket = socket(AF_INET,SOCK_DGRAM) # create UDP socket
message = input('Input lowercase sentence:') # get user keyboard input
clientSocket.sendto(message.encode(),(serverName, serverPort)) # attach server name, port to message; send into socket
modifiedMessage, serverAddress = clientSocket.recvfrom(2048) # read reply data (bytes) from socket
print(modifiedMessage.decode()) # print out received string and close socket
clientSocket.close()