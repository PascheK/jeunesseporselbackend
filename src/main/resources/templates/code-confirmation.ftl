<#ftl encoding="utf-8">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Mail Confirmation d'inscription</title>
</head>

<body style="
background: #f0eff4;    font-family: arial; color: #212529;
">
<div style="font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2">
  <div style="margin:50px auto;width:70%;padding:20px 0">
    <div style="border-bottom:1px solid #eee">
      <a href="" style="font-size:1.4em;color:  #B7161C;text-decoration:none;font-weight:600">Jeunesse de Porsel</a>
    </div>
    <p style="font-size:1.1em">Bonjour ${nom} ${prenom},</p>
    <p>Voilà votre code de confirmation de modification. Vous avez 5 minute pour entrez ce code.</p>
    <h2 style="background: #B7161C;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;">${code}</h2>
    <p style="font-size:0.9em;">Nos meilleurs salutation,<br />Jeunesse de porsel</p>
    <img src="https://jeunessedeporsel.ch/assets/icons/logo-full.svg" alt="logo jeunesse de porsel" style="width: auto; height: 75px;">

  </div>
</div>

</body>

</html>