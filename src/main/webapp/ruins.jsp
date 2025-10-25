<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>The Ruins — The Lost Island</title>
    <style>
        body {
            font-family: "Georgia", serif;
            background: radial-gradient(circle at center, #1a1633 0%, #05010d 100%);
            color: #f1e9ff;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            text-align: center;
            padding: 2em;
        }

        h1 {
            font-size: 2.7em;
            color: #e3b34d; /* golden ruins glow */
            margin-bottom: 1em;
            text-shadow: 0 0 15px rgba(227,179,77,0.4);
        }

        p {
            width: 75%;
            margin-bottom: 2em;
            line-height: 1.7em;
            font-size: 1.1em;
            color: #eae7ff;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1em;
        }

        button {
            background-color: #2a223a;
            color: #f6e9d0;
            border: 1px solid #e3b34d;
            padding: 0.9em 1.5em;
            border-radius: 10px;
            cursor: pointer;
            font-size: 1em;
            transition: all 0.3s ease;
            box-shadow: 0 0 10px rgba(227,179,77,0.2);
        }

        button:hover {
            background-color: #3b2f4a;
            border-color: #ffd37a;
            color: #fff;
            box-shadow: 0 0 15px rgba(255,211,122,0.5);
        }
    </style>
</head>
<body>

<h1>${player.currentState.id}</h1>

<!-- With Artifact -->
<c:if test="${player.hasArtifact}">
    <p>
        The carvings led you to a vast chamber hidden deep beneath the cave.
        Two columns of stone rose before you, carved with symbols that pulsed like veins of light.
        Between them — two hollow grooves, oozing with faint, glowing fluid.
        You and Sam exchanged a glance. No words. Only understanding.
        You both pressed your arms in. The walls came alive.
        The light seared your skin — and when you pulled free,
        the glow followed your veins, crawling up your arms until it sank beneath your flesh.
        The pain was unbearable — but fleeting. When you looked again, the grooves were dry.
        The path ahead split open, revealing a tunnel that pulsed with the same rhythm as your heartbeat.
    </p>
    <p>
        It led to this: a vast, ancient hall bathed in crimson light.
        Pillars of obsidian rose like the bones of a titan, each carved with spiraling marks.
        At the far end stood a massive circular frame — a doorway of stone and living metal,
        its surface rippling like water.
        The marks on your arms shimmered. The doorway answered,
        its runes glowing brighter, awakening to your presence.
        Sam looked at you — awe and terror fighting in his eyes.
        “John… it knows us.”
    </p>
</c:if>

<!-- Without Artifact -->
<c:if test="${!player.hasArtifact}">
    <p>
        You and Sam awoke to the pale light of dawn filtering through the cracks in the cave ceiling.
        The carvings that had glowed in the dark were now dull and lifeless.
        You found a wall covered in strange symbols, and between them —
        two hollow grooves that looked like something had once flowed through them.
        Sam touched one and pulled back instantly. Cold.
        “Whatever this was,” he muttered, “it’s dead now.”
        You felt a faint disappointment you couldn’t explain.
        You packed up and kept moving — deeper, through a narrow tunnel that led underground.
    </p>
    <p>
        It opened into a vast hall of black stone and dust.
        The carvings shimmered faintly, but no warmth came from them.
        At the far end, a circular structure — a door of some kind —
        stood silent, etched with the same symbols you’d seen before.
        Sam’s voice was barely a whisper. “It looks like it’s meant to open.”
        Nothing happened. The air felt heavy, stagnant —
        as if the ruins were holding their breath, waiting for something you didn’t bring.
    </p>
</c:if>

<form action="game" method="post">
    <c:forEach var="entry" items="${player.currentState.choices}">
        <button type="submit" name="choice" value="${entry.key}">
            ${entry.value.text}
        </button>
    </c:forEach>
</form>

</body>
</html>

