

function myFunction() {
  document.getElementById("demo3").innerHTML = "Paragraph changed.";
}

function displayDate() {
  document.getElementById('demo').innerHTML = Date();
}

const url = 'http://localhost:8080/getInfo'
const url2 = 'http://localhost:8080/PlayerPlacedCard'

async function testingData(){
    const response = await fetch(url)
    console.log("Logging data")
    console.log(response)
    if(response.ok){
        document.getElementById("testTestFile").innerHTML = response.json();
        console.log("Received a response from spring boot")
        console.log(response.url)
    } else{
        document.getElementById("testTestFile").innerHTML = "response was not okay";
    }

}

function playerCardFunction() {
    console.log(document.getElementById('playerCardField').value)
    if(document.getElementById('playerCardField').value != ""){
        document.getElementById("playerCardWarning").innerHTML = "Card was sent";
        const playCardUrl = 'http://localhost:8080/hostPlaysCard'
        const cardValue = document.getElementById('playerCardField').value;
        const cardUrl = playCardUrl + "/" + cardValue + "/NONE";
        console.log(cardUrl)
        const response = fetch(cardUrl)
        console.log(response)

        document.getElementById('playerCardField').value = "";

    } else {
        document.getElementById("playerCardWarning").innerHTML = "No Card was selected";
        document.getElementById('playerCardField').value = "";
        window.location.reload(true);

    }

}

function drawCardFunctionHost(){
    const drawCardUrl = 'http://localhost:8080/drawCard/1';
    console.log(drawCardUrl);
    const response = fetch(drawCardUrl);
    console.log(response);
    document.getElementById("playerCardWarning").innerHTML = "Player Drawing a Card";
}

function playerPlaceCardFunction() {
    console.log(document.getElementById('playerCardField').value)
    if(document.getElementById('playerCardField').value != ""){
        document.getElementById("playerCardWarning").innerHTML = "Card was sent";
        const playCardUrl = 'http://localhost:8080/playerPlaysCard'
        const cardValue = document.getElementById('playerCardField').value;
        console.log(cardValue)
        /*
        const playerNumber2 = document.getElementById('hiddenPlayerNumber2').value;
        console.log(playerNumber2)
        const playerNumber = document.getElementById('hiddenPlayerNumber').value;
        console.log(playerNumber)
        const cardUrl = playCardUrl + "/" + playerNumber + "/" + cardValue + "/NONE";
        console.log(cardUrl)
        const response = fetch(cardUrl)
        console.log(response)
        */


        document.getElementById('playerCardField').value = "";

    } else {
        document.getElementById("playerCardWarning").innerHTML = "No Card was selected";
        document.getElementById('playerCardField').value = "";
        window.location.reload(true);

    }

}


function discardPileCardFunction(){

    if(document.getElementById('discardPileText').value != ""){
        const discardPileValue = document.getElementById('discardPileText').value;
        const discardURL = 'http://localhost:8080/discardPileRiggeing/' + discardPileValue;
        const response = fetch(discardURL)
        console.log(response)
        document.getElementById("playerCardWarning").innerHTML = "Discard pile was updated";

    } else {
        document.getElementById("playerCardWarning").innerHTML = "No Card was selected";
    }
}

function player1HandRiggedFunction(){
    console.log("Entered Player 1 hand rigged function");
    if(document.getElementById('Player1HandText').value != ""){
        const player1HandValue = document.getElementById('Player1HandText').value;
        const player1RiggURL = 'http://localhost:8080/playerHandRiggeing/1/' + player1HandValue;
        const response = fetch(player1RiggURL)
        console.log(response)
        document.getElementById("Player1HandWarning").innerHTML = "Player 1's hand was updated";

    } else {
        document.getElementById("Player1HandWarning").innerHTML = "No Card was selected";
    }
}

function player2HandRiggedFunction(){
    console.log("Entered Player 2 hand rigged function");
    if(document.getElementById('Player2HandText').value != ""){
        const player2HandValue = document.getElementById('Player2HandText').value;
        const player2RiggURL = 'http://localhost:8080/playerHandRiggeing/2/' + player2HandValue;
        const response = fetch(player2RiggURL)
        console.log(response)
        document.getElementById("Player2HandWarning").innerHTML = "Player 2's hand was updated";

    } else {
        document.getElementById("Player2HandWarning").innerHTML = "No Card was selected";
    }
}

function player3HandRiggedFunction(){
    console.log("Entered Player 3 hand rigged function");
    if(document.getElementById('Player3HandText').value != ""){
        const player3HandValue = document.getElementById('Player3HandText').value;
        const player3RiggURL = 'http://localhost:8080/playerHandRiggeing/3/' + player3HandValue;
        const response = fetch(player3RiggURL)
        console.log(response)
        document.getElementById("Player3HandWarning").innerHTML = "Player 3's hand was updated";

    } else {
        document.getElementById("Player3HandWarning").innerHTML = "No Card was selected";
    }
}

function player4HandRiggedFunction(){
    console.log("Entered Player 4 hand rigged function");
    if(document.getElementById('Player4HandText').value != ""){
        const player4HandValue = document.getElementById('Player4HandText').value;
        const player4RiggURL = 'http://localhost:8080/playerHandRiggeing/4/' + player4HandValue;
        const response = fetch(player4RiggURL)
        console.log(response)
        document.getElementById("Player4HandWarning").innerHTML = "Player 4's hand was updated";

    } else {
        document.getElementById("Player4HandWarning").innerHTML = "No Card was selected";
    }
}


function loadDoc() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("testTestFile").innerHTML =
    this.responseText;
  }
  xhttp.open("GET", "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\Assignment3-Code\\Assignment3\\src\\main\\resources\\static\\testTextFile.txt");
  xhttp.send();
}