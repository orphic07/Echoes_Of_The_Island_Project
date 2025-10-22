<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Jungle — The Lost Island</title>
    <style>
        body {
            font-family: "Georgia", serif;
            background: radial-gradient(circle at center, #0f1e12 0%, #081008 100%);
            color: #dcdcdc;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
            padding: 2em;
            overflow-y: auto;
        }

        h1 {
            font-size: 2.4em;
            margin-bottom: 2em;
            color: #9fc490;
            opacity: 0.7;
            text-align: center;
        }

        p {
            width: 65%;
            margin-bottom: 2em;
            font-size: 1.2em;
            line-height: 1.7em;
            text-indent: 1.5em;
            color: #e8e8dc;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1em;
            margin-bottom: 4em;
        }

        button {
            background-color: #153d23; /* deep greenish tone */
            color: #e8e8dc; /* soft parchment color */
            border: 1px solid #2a5a35;
            padding: 0.8em 1.2em;
            border-radius: 7px;
            cursor: pointer;
            font-size: 1em;
            transition: all 0.3s ease;
        }

        button:hover {
            background-color: #1f5d35; /* lighter green glow */
            border-color: #3d8a56;
            color: #fff;
        }
    </style>
</head>
<body>

    <h1>${player.currentState.id}</h1>

    <p>
        The jungle breathes.

        Light filters through crimson-tinted leaves, painting the air in a strange red haze. Every plant glows faintly — veins pulsing like they’re alive.

        “This place…” Sam whispers, reaching out to touch a vine that recoils before his fingers can graze it. The air hums softly, thick with warmth and the scent of earth.

        The deeper you walk, the stranger it feels. Colors shift where they shouldn’t, and shadows move even when nothing does.

        Then it comes — a scream, deep and guttural, echoing through the trees. Human, but not quite.

        Sam freezes. “That wasn’t—” he starts, but stops himself.

        The jungle falls completely silent.

        You exchange a glance. Do you follow the sound… or get the hell out of there?
    </p>

    <form action="game" method="post">
        <c:forEach var="entry" items="${player.currentState.choices}">
            <button type="submit" name="choice" value="${entry.key}">
                ${entry.value.text}
            </button>
        </c:forEach>
    </form>

</body>
</html>

