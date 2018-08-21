Ivanhoe
===================================

Ivanhoe is a muti player board game that a good way to get familar with theory and development software systems.


Introduction
------------

Learning Software Design is a big topic of our target. Therefore, we believe the
project of Ivanhoe is a good way to improve us about understanding Agile Development.
This project is designing over TDD and JUnit test. Therefore, we could get familiar with
those two technical skills. Design Pattern is technical important to Software Design; we
could get the experience of learning how to implement Design Pattern into the program of
Ivanhoe. And we could study the Scenario and how to evaluate each Scenario. We are
looking forward to implement the network into the program because Ivanhoe is a multiplayer
game. It is very great to implement the network feature into the game.


Overall Architecture
--------------------

Server is only transfer the message between Rule Engine and clients. Server would
only send and receive the message from Client and Rule Engine. Client is only transfer the
message between UI and server. Client would only send and receive the message from
Server and send message by UI. Rule Engine is only control the game of Ivanhoe which
would take control whole game. It would distribute the request and respond of each action
of each player in every state.


Use Case Diagram
----------------

The diagram of the Ivanhoe over the networking to demonstrate how the Ivanhoe
work

<img src="Report/Images/Use Case Diagram.jpg" height="600" alt="Screenshot"/> 


Class Diagram
----------------

The diagram of the Ivanhoe over the project to demonstrate all classes

<img src="Report/Images/Class Diagram.jpg" height="600" alt="Screenshot"/> 


Server Strategy
---------------

Server is the host of the Ivanhoe. Server would run the game and control the
procedure of the game. The responsibility of the server would be report the result of client’s
response to the Rule Engine of Ivanhoe. The key feature of server is communicating with
clients over the network. Ivanhoe is a multiple player game. Therefore, the server be
handling multi clients in every time. No matter how many requests is received, the server
could handle it and report it to Rule Engine. Server would not response to clients if the Rule
Engine recognize the request is not valid. When any clients are quit or accidently exit the
game, the server could be terminated the game by send the message to rest of the clients.
The message is the information of the server is down due to client loss. The server is well
implemented with the setting of the network which is allowed to change the setting of the
number players in the game, the IP address and port number. It is implemented for running
the game over the network in different devices. It is allowed the player play the game in
anywhere.


Client Strategy
---------------

Client is the side of Ivanhoe player. Client is able to join the game and play the game
and quit the game. The responsibility of the client is participated the game of Ivanhoe.
Client is able to join the game and play. The key feature of client is communicating with
server over the network. Client is treat as the player side of the Ivanhoe. Therefore, the
client is able to do any corresponding action depend on the state of the game which means,
client is able to update the newest information to Rule Engine. No matter what the client do,
the client is not able to update anything unless server’s response. Client is automatically
received the any message from the server. And automatically update the message from the
server to the UI. Client is free to report any actions from the players to the server. But the
action is not response immediately unless the action is corresponding to the request action
from the server. When the server is shut down. Client could receive the message of the
server is down and the client could be automatically quit the server and terminated. The
client is well implemented with the setting of the network which is allowed to change the
setting of the IP address or port number. It is implemented for joining the game over the
network. It is allowed the player to join if any game is open.


Message Strategy
----------------
The message is used for communicating between the network which record the data
of the current state of Rule Engine. The message is serialized object that is secure to
transfer over network. The responsibility of the message is carrying the data packet of Rule
Engine. The key feature of the message is encapsulating the header and the body. The
header represents the sender, receiver, the state of the game and the type of the state. And
the body is player information which is designing by the data collection of HashMap. It is
really easier to manipulate for the program. The message could be generated by the Rule
Engine which recording the current state of the game. It is including the information of
each players and the state of the game. The message is designed by carrying the
information. Therefore, the client will be able to use the message to update UI immediately.