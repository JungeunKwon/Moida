module.exports = {
	root: true,
	env: {
		node: true,
	},
	extends: ["eslint:recommended", "plugin:vue/essential"],
	plugins: ["prettier"],
	rules: {
		"no-console": process.env.NODE_ENV === "production" ? "error" : "off",
		"no-debugger": process.env.NODE_ENV === "production" ? "error" : "off",
	},
};
