# JavaDiscordWebhook
Une librairie qui permet d'utiliser les webhooks facilement avec Java Discord API
Fait par Romain MILLAN

## Parties
1. [Commencer facilement](#getting-started)
    - [Crée un client](#create-client)
    - [Envoyer un message](#send-messages)
       - [Envoyer un message texte](#send-textmessages)
       - [Envoyer un embed](#send-embeds)
2. [Changer les informations de la webhook](#change-webhook-metas)
3. [Télécharger](https://github.com/MauricePascal/JavaDIscordWebhookClient/raw/master/out/artifacts/JavaDiscordWebhookClient/JavaDiscordWebhookClient.jar)

## Commencer facilement
### Crée un client
```java
JavaDiscordWebhook webhook = new JavaDiscordWebhook.Builder()
   .setToken("TOKEN DE LA WEBHOOK")
   .setID("ID DE LA WEBHOOK") //LONG
   .build();
```
### Envoyer un message
#### Envoyer un message texte
```java
webhook.setContent("Salut tous le monde !"); //Définie le contenue du message
webhook.execute(); //Execute le client et envoye les messages
```
*Vous pouvez aussi activé le TTS*
```java
webhook.setContent("Salut tous le monde !"); //Définie le contenue du message
webhook.setTts(true); //Active le TTS
webhook.execute(); //Execute le client et envoye les messages
```
#### Envoyer des embeds
```java
EmbedObject embed = new EmbedObject();
    embed.setTitle("Hello World"); //Définie le titre
    embed.setAuthor("MauricePascal#3009", "https://github.com/Wabez3ter", null); //Définie l'author
    embed.setColor(Color.CYAN); //Définie la couleur
    embed.setDescription("Une belle description"); //Définie la description
    embed.setFooter("By Romain MILLAN", null); //Définie le footer
        
webhook.addEmbed(embed); //Ajoute l'embed à la liste des embeds à envoyer
webhook.execute(); //Execute le client et envoye les messages
webhook.clearEmbeds() //Permet de clear la liste des embeds
```
### Changer les informations de la webhook
```java
webhook.setUsername("Webhook"); //Définie le nom de la webhook
webhook.setAvatarUrl("https://cdn.discord.com/avatars/xxxxxxxxxxxxxx/xxxxxxxxxxxxxxxxxxxxxxxxxx.png"); //Définie l'avatar de la webhook
```
