Feature: Login Customer to App

	@LoginValid
	Scenario: Login dengan User Terdaftar
		Given User berada di halaman login
		When User input email
		And User input password
		Then  User berhasil login
		
	@LoginInvalid
	Scenario: Login dengan User Terdaftar
		Given User berada di halaman login
		When User input email salah
		And User input password salah
		Then  User tidak berhasil login