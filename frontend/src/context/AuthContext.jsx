import { createContext, useContext, useEffect, useState } from "react";

const AuthContext = createContext();

export function AuthProvider({ children }) {

    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

    const checkSession = async () => {

        try {

            const response = await fetch(
                "http://localhost:8080/auth/me",
                {
                    credentials: "include"
                }
            );

            if (!response.ok) {
                setUser(null);
                return;
            }

            const userData = await response.json();

            setUser(userData);

        } catch (error) {

            console.error("Error comprobando sesión:", error);
            setUser(null);

        } finally {

            setLoading(false);
        }
    };

    checkSession();

}, []);

    const login = async (nick, password) => {

        setLoading(true);

        try {
            const response = await fetch("http://localhost:8080/auth/login", {
                method: "POST",
                credentials: "include",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    nick,
                    password
                })
            });

            if (!response.ok) {
                throw new Error("Credenciales incorrectas");
            }

            // La cookie JWT se guarda automáticamente.
            // Ahora podemos pedir los datos del usuario.
            const userResponse = await fetch(
                "http://localhost:8080/auth/me",
                {
                    credentials: "include"
                }
            );

            const userData = await userResponse.json();

            setUser(userData);

        } finally {
            setLoading(false);
        }
    };

    const logout = async () => {

        await fetch("http://localhost:8080/auth/logout", {
            method: "POST",
            credentials: "include"
        });

        setUser(null);
    };

    return (
        <AuthContext.Provider
            value={{
                user,
                loading,
                login,
                logout,
                isAuthenticated: user !== null
            }}
        >
            {children}
        </AuthContext.Provider>
    );

    
}

export function useAuth() {
    return useContext(AuthContext);
}