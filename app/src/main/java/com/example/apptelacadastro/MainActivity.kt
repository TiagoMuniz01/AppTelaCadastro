package com.example.apptelacadastro

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apptelacadastro.ui.theme.AppTelaCadastroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTelaCadastroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaInicial()
                }
            }
        }
    }
}

@Composable
fun TelaInicial() {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar()
        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome Completo") }
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Telefone") }
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = curso,
                onValueChange = { curso = it },
                label = { Text("Curso") }
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = serie,
                onValueChange = { serie = it },
                label = { Text("Série") }
            )
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = { /* Ação de envio */ }
            ) {
                Text(text = "Enviar Dados")
            }
        }
    }
}

@Composable
fun Avatar() {
    Column(
        Modifier
            .height(320.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(
                painter = painterResource(R.drawable.avatar_image),
                contentDescription = "imagem de avatar",
                Modifier
                    .offset(y = 50.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
                    .size(150.dp)
            )
        }
        Spacer(Modifier.height(65.dp))
        Text(
            text = "Cadastro de Alunos",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
