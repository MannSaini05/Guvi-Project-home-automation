// validation.js
export const validateEmail = (email) => {
    return /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email) || "Invalid email address.";
};

export const validatePassword = (password) => {
    return password.length >= 8 || "Password must be at least 8 characters.";
};
