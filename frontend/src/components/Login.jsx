import { useState } from "react";
import { useAuth } from "../context/AuthContext.jsx";

function Login() {

    const { login, loading } = useAuth();

    const [nick, setNick] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {

        e.preventDefault();
        setError("");

        try {
            await login(nick, password);
        } catch (error) {
            setError(error.message);
        }
    };

    return (
        <form onSubmit={handleSubmit}>

            <input
                type="text"
                placeholder="Nick"
                value={nick}
                onChange={(e) => setNick(e.target.value)}
            />

            <input
                type="password"
                placeholder="Contraseña"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />

            <button type="submit" disabled={loading}>
                {loading ? "Entrando..." : "Login"}
            </button>

            {error && <p>{error}</p>}

        </form>
    );
}

export default Login;