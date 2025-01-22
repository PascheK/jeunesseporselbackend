<#ftl encoding="utf-8">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Mail Confirmation d'inscription</title>
</head>

<body style="
background: #f0eff4;    font-family: arial; color: #212529;
">
<div style="display: flex;  flex-direction: column;  align-items: center;">
  <div style="border-radius: 10px;    box-shadow: 0px 0px 15px 5px rgb(33 37 41 / 15%);    padding: 3.5rem; margin: 10px;">
    <h3>Bonjour ${nom} ${prenom},</h3>
    <p>Vous vous êtes inscrit pour la ${eventName} ! Vous avez réservez ${nbPlace}.</p><br>
    <p>Nous avonz hâte de vous voir le ${date}.</p>
    <p>Si vous voulez changez le nombre de place vous pouvez le faire sur le site web de la jeunesse ou par message au : +41763103560.<br> Veuillez communiqué votre numéro d'inscription : ${numero}</p>
    <img src="https://jeunessedeporsel.ch/assets/icons/logo-full.svg" alt="logo jeunesse de porsel" style="width: auto; height: 100px;">
  </div>
</div>


</body>

</html>