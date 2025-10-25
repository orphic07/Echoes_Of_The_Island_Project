<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>End Cave — The Lost Island</title>
    <style>
        body {
            font-family: "Georgia", serif;
            background: radial-gradient(circle at center, #0d0d0d 0%, #1a1a1a 100%);
            color: #e2e2e2;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            text-align: center;
            padding: 3em;
        }

        h1 {
            font-size: 2.5em;
            margin-bottom: 1em;
            color: #b8b8b8;
            opacity: 0.8;
        }

        p {
            width: 75%;
            font-size: 1.1em;
            line-height: 1.8em;
            margin-bottom: 2em;
        }

        .ending-title {
            font-size: 1.5em;
            margin-top: 1em;
            color: #ffcc66;
            opacity: 0.9;
        }

        form {
            margin-top: 2em;
        }

        button {
            background-color: #222;
            color: #ddd;
            border: 1px solid #555;
            padding: 0.8em 1.2em;
            border-radius: 7px;
            cursor: pointer;
            font-size: 1em;
            transition: all 0.3s ease;
        }

        button:hover {
            background-color: #444;
            border-color: #888;
            color: #fff;
        }

        .fade-text {
            opacity: 0;
            transition: opacity 1.5s ease;
        }
        .fade-text.visible {
            opacity: 1;
        }

        #statsBox {
            position: fixed;
            left: 18px;
            bottom: 18px;
            background: rgba(255, 255, 255, 0.08); /* lighter, subtle glow */
            border: 1px solid rgba(255, 255, 255, 0.15);
            padding: 8px 12px;
            border-radius: 8px;
            font-size: 0.9em;
            color: #e0e0e0;
            max-width: 260px;
            text-align: left;
            z-index: 9999;
            box-shadow: 0 4px 18px rgba(255,255,255,0.05);
            backdrop-filter: blur(6px); /* softens it visually */
        }
        #statsBox p {
                    margin: 4px 0;
                    white-space: normal;
                    overflow: hidden;
                    text-overflow: ellipsis;
                    line-height: 1.2em;
                }
        #statsBox strong { color: #fff; font-size: 0.95em; }

    </style>
</head>
<body>

<h1>The End Cave</h1>

<!-- ========== ARTIFACT TRUE + CHOICE A ========== -->
<c:if test="${player.hasArtifact and lastChoice == 'A'}">
    <p class="fade-text">
        The moment your hands touch the stone, the cave trembles.
        The fragments of the artifact embedded in your arms ignite, light flowing through veins like liquid fire.
        Sam’s gasp echoes — fear and awe at once.

        The symbols awaken. The air vibrates, humming with something ancient and alive.
        The mechanism responds, stone folding and shifting until a massive gate stands before you, a tear of light pulsing in its heart.

        You glance at Sam. For the first time since the wreck, there’s hope — wild, unshakable hope.
        You both step forward.
    </p>
    <p class="ending-title">Ending A — *The Gate Opens*</p>
    <p class="fade-text">
        A blinding light swallows everything. The island fades, and so do you.
    </p>
</c:if>

<!-- ========== ARTIFACT TRUE + CHOICE B ========== -->
<c:if test="${player.hasArtifact and lastChoice == 'B'}">
    <p class="fade-text">
        The mechanism hums softly, almost calling you.
        But something deep inside you whispers — *not yet.*
        The air feels heavy, sacred, and wrong all at once.

        Sam exhales in relief as you step back from the altar. The glow fades, leaving the ruins silent once more.

        Days pass. You find a rhythm — food, shelter, warmth.
        The island is quiet, but sometimes, in the dark, you see faint lights flickering in the cave’s distance — like the island still remembers what you refused to awaken.
    </p>
    <p class="ending-title">Ending C — *The Ones Who Stayed*</p>
    <p class="fade-text">
        You survive, but part of you still wonders what waited beyond the light.
    </p>
</c:if>

<!-- ========== ARTIFACT FALSE + CHOICE A ========== -->
<c:if test="${!player.hasArtifact and lastChoice == 'A'}">
    <p class="fade-text">
        You press your hands against the cold stone.
        The markings blaze for a second — too bright, too fast.
        Then everything goes wrong.

        The symbols distort, melting like wax. The walls twist and scream as the energy builds without control.
        Sam shouts your name, but the roar of the collapsing chamber drowns it out.

        Light, heat, and pain consume everything.
        The ruins vanish beneath the sea once more.
    </p>

    <p class="ending-title">Ending B — *The Island Takes You Back*</p>
    <p class="fade-text">
        When the storm clears, the beach is empty.
    </p>
</c:if>

<!-- ========== ARTIFACT FALSE + CHOICE B ========== -->
<c:if test="${!player.hasArtifact and lastChoice == 'B'}">
    <p class="fade-text">
        The silence in the ruins grows unbearable.
        You and Sam walk away from the mechanism, neither of you daring to speak.
        The deeper you go, the less the world seems real — until the cave simply ends.
        Back on the beach, the sky is the same gray as the day you arrived.
        The sea is calm, the sand cold and black.
        You sit. You breathe. You wait.
    </p>
    <p class="ending-title">Ending D — *The Endless Shore*</p>
    <p class="fade-text">
        Somewhere far away, thunder rolls again.
    </p>
</c:if>

<div id="statsBox">
    <p><strong>Deaths:</strong> ${stats.deaths}</p>
    <p><strong>Games Played:</strong> ${stats.gamesPlayed}</p>
    <p><strong>Ending A (The True Escape):</strong> ${stats.endingA}</p>
    <p><strong>Ending B (The Silent Collapse):</strong> ${stats.endingB}</p>
    <p><strong>Ending C (The Corrupted Path):</strong> ${stats.endingC}</p>
    <p><strong>Ending D (The Lost Wanderers):</strong> ${stats.endingD}</p>
</div>

<form action="game" method="get" id="retryForm">
        <input type="hidden" name="action" value="restart">
        <button type="submit">Play Again</button>
    </form>

<script>
    document.addEventListener("DOMContentLoaded", () => {
        const paragraphs = document.querySelectorAll(".fade-text");
        paragraphs.forEach((p, index) => {
            setTimeout(() => {
                p.classList.add("visible");
            }, index * 5000); //
        });
    });
</script>

</body>
</html>
